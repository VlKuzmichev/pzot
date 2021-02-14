package rzd.oao.zrw.pzot.util;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No data found")
public class NotFoundException extends RuntimeException {
    public NotFoundException(String arg) {
        super(arg);
    }
}


