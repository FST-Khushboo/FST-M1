package activities;


class CustomException extends  Exception
{
    private String message = null;
    CustomException( String message)
    {
        this.message = message;

    }
    public String getMessage() {
        return message;
    }
}
public class activity8 {
    public static void main(String args[]) {
        try {
            activity8.exceptionTest("Will print to console");
            System.out.print("\n");
            activity8.exceptionTest(null);
            activity8.exceptionTest("No result");
        } catch (Exception exp) {
            System.out.print("Inside block" + exp.getMessage());
        }


    }

    private static void exceptionTest(String message) throws Exception {
        if (message == null) {
            throw new Exception("String is NULL");
        }
        else {

            System.out.print(message);
        }
    }
}


