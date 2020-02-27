package rzd.oao.zrw.pzot.util;

public class NotFoundException extends RuntimeException {
    public static final String NOT_FOUND_EXCEPTION = "exception.common.notFound";

    public NotFoundException(String arg) {
        super(NOT_FOUND_EXCEPTION);
    }
}