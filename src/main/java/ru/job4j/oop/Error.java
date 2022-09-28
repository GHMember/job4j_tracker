package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {

    }

    public void showInfo() {
        System.out.println("Наличие ошибки: " + active);
        System.out.println("Статус ошибки: " + status);
        System.out.println("Причина ошибки: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.showInfo();
        Error error404 = new Error(true, 404, "Страница не найдена");
        error404.showInfo();
        Error answer200 = new Error(false, 200, "Запрос выполнен успешно");
        answer200.showInfo();

    }

}