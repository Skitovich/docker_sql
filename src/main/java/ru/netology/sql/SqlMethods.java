package ru.netology.sql;

import lombok.Value;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlMethods {
    public SqlMethods() {
    }

    @Value
    public static class CodeInfo {
        String code;
    }


    public static void clearTables () {
        val clearUsers = "DELETE FROM users";
        val clearCodes = "DELETE FROM auth_codes";
        val clearCards = "DELETE FROM cards";
        val clearCardTransactions = "DELETE FROM card_transactions";
        val runner = new QueryRunner();

        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                )
        ) {
            runner.update(conn, clearCardTransactions);
            runner.update(conn, clearCards);
            runner.update(conn, clearCodes);
            runner.update(conn, clearUsers);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


}
