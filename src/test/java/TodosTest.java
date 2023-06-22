import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SimpleTaskquerryTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SimpleTaskquerryF() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Телефон");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicquerryTrue() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicQuerryF() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Помидоры");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingquerryTrue() {

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("Выкатка");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingquerryTrueProgect() {

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("НетоБанка");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingquerryF() {

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("обеда");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SimpleTaskquerryFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicquerryFalse() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Кефир");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingquerryFalse() {

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("Выкатка");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SearchQuerry() {
        SimpleTask simpleTask = new SimpleTask(5, "Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии Приложения", "Приложение Хлеб", "Во вторник после обеда");

        Todos todos = new Todos();


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Хлеб");
        Task[] expected = {simpleTask, epic, meeting};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchQuerrytwo() {
        SimpleTask simpleTask = new SimpleTask(5, "Создать Приложения");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии Приложения", "Приложение Нетобанк", "Во вторник после обеда");

        Todos todos = new Todos();


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Приложения");
        Task[] expected = {simpleTask, meeting};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchQuerryOne() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии Приложения", "Приложение Нетобанк", "Во вторник после обеда");

        Todos todos = new Todos();


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("родителям");
        Task[] expected = {simpleTask};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchQuerryNull() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии Приложения", "Приложение Нетобанк", "Во вторник после обеда");

        Todos todos = new Todos();


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("телефон");
        Task[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
