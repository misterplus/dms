package plus.misterplus.dms.sql.query.advanced;

import plus.misterplus.dms.sql.dao.FeeDao;
import plus.misterplus.dms.sql.dao.impl.*;
import plus.misterplus.dms.sql.entity.*;

import java.util.List;

public class InfoQuery {
    public static DormRoom selectDormRoom(String dbno, String dbd, String drbno) {
        return DormRoomDaoImpl.getInstance().selectDormRoom(dbno, dbd, drbno);
    }

    public static DormRoom selectStudentDorm(String sno) {
        return StudentDaoImpl.getInstance().selectStudentDorm(sno);
    }

    public static List<RepairSheet> selectRepairSheetsWithSno(String sno) {
        return RepairSheetDaoImpl.getInstance().selectRepairSheetsWithSno(sno);
    }

    public static List<Fee> selectFeesWithSno(String sno) {
        return FeeDaoImpl.getInstance().selectFeesWithSno(sno);
    }

    public static List<Notice> selectNotices() {
        return NoticeDaoImpl.getInstance().selectNotices();
    }

    public static List<CleanContest> selectCleanContestsWithSno(String sno) {
        return CleanContestDaoImpl.getInstance().selectCleanContestsWithSno(sno);
    }

    public static List<Student> selectStudents() {
        return StudentDaoImpl.getInstance().selectStudents();
    }

    public static Student selectStudentWithSno(String sno) {
        return StudentDaoImpl.getInstance().selectStudentWithSno(sno);
    }

    public static List<Admin> selectAdmins() {
        return AdminDaoImpl.getInstance().selectAdmins();
    }

    public static List<CleanContest> selectContests() {
        return CleanContestDaoImpl.getInstance().selectContests();
    }

    public static List<DormRoom> selectDRooms() {
        return DormRoomDaoImpl.getInstance().selectDRooms();
    }

    public static List<Item> selectItems() {
        return ItemDaoImpl.getInstance().selectItems();
    }

    public static List<Guest> selectGuests() {
        return GuestDaoImpl.getInstance().selectGuests();
    }

    public static List<DormRoom> selectDRoomNotFull() {
        return DormRoomDaoImpl.getInstance().selectDRoomNotFull();
    }

    public static List<Student> selectDormStudents(String dbno, String dbd, String drbno) {
        return StudentDaoImpl.getInstance().selectDormStudents(dbno, dbd, drbno);
    }

    public static List<Fee> selectFees() {
        return FeeDaoImpl.getInstance().selectFees();
    }
}
