dataSource {
    pooled = true
    dbCreate = "update"
    // Driver Oracle
    driverClassName = "oracle.jdbc.driver.OracleDriver"
    //dialect = "org.hibernate.dialect.Oracle10gDialect"
}
hibernate {
    cache.use_second_level_cache=false
    cache.use_query_cache=false
    cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
    dialect = "org.hibernate.dialect.Oracle10gDialect"
}
environments {
    // Nombre de la base de datos con la que trabajaremos

    //Entorno de  Desarrollo
    development {
        dataSource {
            dbCreate = "update"
            // Usuario
            username = "rentacar"
            password = "rentacar"
            url = "jdbc:oracle:thin:@localhost:1521:XE"
        }
    }
    // Entorno Test
    test {
        dataSource {
            dbCreate = "update"
            // Usuario
            username = "rentacar"
            password = "rentacar"
            url = "jdbc:oracle:thin:@localhost:1521:xe"
        }
    }
    // Entorno de Produccion
    production {
        dataSource {
            dbCreate = "update"
            // Usuario
            username = "rentacar"
            password = "rentacar"
            url = "jdbc:oracle:thin:@localhost:1521:xe"
        }
    }
}