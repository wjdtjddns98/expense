package mysite.expense.exception;

import lombok.Getter;

@Getter
public class ExpenseNotFoundException extends RuntimeException {

    private String message;

    public ExpenseNotFoundException(String message) {
        this.message = message;
    }
}
