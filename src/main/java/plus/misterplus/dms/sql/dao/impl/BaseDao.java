package plus.misterplus.dms.sql.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import plus.misterplus.dms.sql.utils.CodeHelper;
import plus.misterplus.dms.sql.utils.Linker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private final QueryRunner queryRunner = new QueryRunner();

    public int insert(String sql, Object... params) {
        Connection db = Linker.getDb();
        try {
            return queryRunner.update(db, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CodeHelper.close(db);
        }
        return -1;
    }

    public <T> T select(Class<T> type, String sql) {
        Connection db = Linker.getDb();
        try {
            return queryRunner.query(db, sql, new BeanHandler<>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CodeHelper.close(db);
        }
        return null;
    }

    public <T> T select(Class<T> type, String sql, Object... params) {
        Connection db = Linker.getDb();
        try {
            return queryRunner.query(db, sql, params, new BeanHandler<>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CodeHelper.close(db);
        }
        return null;
    }

    public <T> List<T> selectMultiple(Class<T> type, String sql) {
        Connection db = Linker.getDb();
        try {
            return queryRunner.query(db, sql, new BeanListHandler<>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CodeHelper.close(db);
        }
        return null;
    }

    public <T> List<T> selectMultiple(Class<T> type, String sql, Object... params) {
        Connection db = Linker.getDb();
        try {
            return queryRunner.query(db, sql, params, new BeanListHandler<>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CodeHelper.close(db);
        }
        return null;
    }

    public int update(String sql, Object... params) {
        Connection db = Linker.getDb();
        try {
            return queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CodeHelper.close(db);
        }
        return 0;
    }
}
