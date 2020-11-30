package plus.misterplus.dms.web.servlet;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import plus.misterplus.dms.sql.entity.Student;
import plus.misterplus.dms.sql.query.advanced.EditQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/importServlet")
public class ImportServlet extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "upload";

    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    private String getNumberDirection(String dbd) {
        switch (dbd) {
            case "无": {
                return "0";
            }
            case "东": {
                return "1";
            }
            case "南": {
                return "2";
            }
            case "西": {
                return "3";
            }
            case "北": {
                return "4";
            }
        }
        return "";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        upload.setHeaderEncoding("UTF-8");
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                        ExcelReader reader = ExcelUtil.getReader(storeFile, 0);
                        List<List<Object>> sheet = reader.read();
                        for (List<Object> stu : sheet) {
                            Student student = new Student(stu.get(0).toString(), "                ", stu.get(1).toString(), stu.get(2).toString(), getNumberDirection(stu.get(3).toString()), stu.get(4).toString());
                            EditQuery.insertStudent(student);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/admin/main.jsp");
    }
}
