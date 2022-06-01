open module com.example.backend {
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.sql;
    requires java.xml.bind;

    exports com.example.backend.entity;
    exports com.example.backend.BLL;
}