package customExceptions;


public class ResourceException extends Exception {

// Для повышения качества и скорости восприятия кода разработчику следует создать
// собственное исключение как подкласс класса Exception, а затем использовать его при
// обработке ситуации, не являющейся исключением с точки зрения языка, НО нарушающей логику вещей.

    //У подкласса класса Exception обычно определяются минимум три конструктора,
    // два из которых в качестве параметра принимают объект типа Throwable,
    //что означает генерацию исключения на основе другого исключения.
//Один из параметров — сообщение, которое может быть выведено в поток ошибок;
// другой — реальное исключение, которое привело к вызову собственного исключения.

    public ResourceException() {
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }


}
