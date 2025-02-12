DO
$$
    BEGIN
        IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'postgres_db') THEN
            CREATE DATABASE postgres_db;
        END IF;
    END
$$;