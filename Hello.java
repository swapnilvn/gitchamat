

class Hello{

    Log logger = LogFactory.getLog(Hello.class);
    public static void main(String[] args) {
        logger.info("This is an info message");
        logger.info("This is an info dd message");
        logger.info("This is an info ff message");
        logger.info("This is an info gghj message");
    }
    public static void test(){
        System.out.println("This is a test method");
    }

}