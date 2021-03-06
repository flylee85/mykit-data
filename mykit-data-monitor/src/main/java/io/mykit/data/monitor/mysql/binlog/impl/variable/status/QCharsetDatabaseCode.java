package io.mykit.data.monitor.mysql.binlog.impl.variable.status;


import io.mykit.data.monitor.mysql.common.util.MySQLConstants;
import io.mykit.data.monitor.mysql.common.util.ToStringBuilder;
import io.mykit.data.monitor.mysql.io.XInputStream;

import java.io.IOException;

public class QCharsetDatabaseCode extends AbstractStatusVariable {
    public static final int TYPE = MySQLConstants.Q_CHARSET_DATABASE_CODE;

    private final int collationDatabase;

    public QCharsetDatabaseCode(int collationDatabase) {
        super(TYPE);
        this.collationDatabase = collationDatabase;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("collationDatabase", collationDatabase).toString();
    }

    public int getCollationDatabase() {
        return collationDatabase;
    }

    public static QCharsetDatabaseCode valueOf(XInputStream tis) throws IOException {
        final int collationDatabase = tis.readInt(2);
        return new QCharsetDatabaseCode(collationDatabase);
    }
}
