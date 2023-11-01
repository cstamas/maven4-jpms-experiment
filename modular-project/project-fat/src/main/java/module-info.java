module org.slf4j {
    exports org.slf4j;
    exports org.slf4j.spi;
    exports org.slf4j.event;
    exports org.slf4j.helpers;
    exports org.slf4j.simple;

    uses org.slf4j.spi.SLF4JServiceProvider;

    provides org.slf4j.spi.SLF4JServiceProvider with
            org.slf4j.simple.SimpleServiceProvider;

    requires java.base;
}
