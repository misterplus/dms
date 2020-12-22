package plus.misterplus.dms.sql.dao.impl;

public class ProcedureImpl extends BaseDao {

    private static final ProcedureImpl instance = new ProcedureImpl();

    public static ProcedureImpl getInstance() {
        return instance;
    }

    public int newDorm0(String dbno, int height, int rooms) {
        String sql = "exec newDorm_0 ?,?,?";
        return procedure(sql, dbno, height, rooms);
    }

    public int newDorm12(String dbno, int height, int rooms) {
        String sql = "exec newDorm_12 ?,?,?";
        return procedure(sql, dbno, height, rooms);
    }

    public int newDorm34(String dbno, int height, int rooms) {
        String sql = "exec newDorm_34 ?,?,?";
        return procedure(sql, dbno, height, rooms);
    }

    public int deleteDBuilding(String dbno) {
        String sql = "exec deleteDBuilding ?";
        return procedure(sql, dbno);
    }
}
