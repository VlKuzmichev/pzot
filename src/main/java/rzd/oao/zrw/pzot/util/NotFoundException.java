package rzd.oao.zrw.pzot.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No data found") // 404
public class NotFoundException extends RuntimeException {
    public NotFoundException(String arg) {
        super(arg);
    }
}