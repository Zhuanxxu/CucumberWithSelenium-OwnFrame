package cleanTest;


import org.junit.jupiter.params.provider.Arguments;
import pages.todoIst.LoadingPage;
import pages.todoIst.centersPages.*;
import pages.todoIst.modals.*;
import pages.todoIst.sections.Navbar;
import pages.todoIst.sections.SideBarSection;
import pages.todoIst.settings.SettingsModal;
import utils.GetProperties;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


public class TestBaseCucumber {
    protected HashMap<String, String> priorityMap = new HashMap<String, String>() {{
        put("priority1", "rgba(209, 69, 59, 1)");
        put("priority2", "rgba(235, 137, 9, 1)");
        put("priority3", "rgba(36, 111, 224, 1)");
        put("priority4", "rgba(128, 128, 128, 1)");
    }};
    protected HashMap<String, String> datesColors = new HashMap<String, String>() {{
        put("overdueDate", "rgba(209, 69, 59, 1)");
        put("todayDate", "rgba(5, 133, 39, 1)");
        put("tomorrowDate", "rgba(173, 98, 0, 1)");
        put("thisWeek", "rgba(105, 47, 194, 1)");
        put("moreThanAWeek", "rgba(128, 128, 128, 1)");
    }};
    protected String email = GetProperties.getInstance().getUser();
    protected String pwd = GetProperties.getInstance().getPwd();
    // PAGES
    protected LoadingPage loadingPage = new LoadingPage();
    protected GetProModal getProModal = new GetProModal();
    protected SettingsModal settingsModal = new SettingsModal();
    protected MainPage mainPage = new MainPage();
    protected LoginPage loginPage = new LoginPage();
    protected RegisterPage registerPage = new RegisterPage();
    protected SideBarSection sideBarSection = new SideBarSection();
    protected EditProjectModal editProjectModal = new EditProjectModal();
    protected ChangeCurrentTimezone currentTimezoneModal = new ChangeCurrentTimezone();
    protected Navbar navbar = new Navbar();
    protected ProjectCenterTasksArea project_CenterTasksArea = new ProjectCenterTasksArea();
    protected EditTaskModal editTaskModal = new EditTaskModal();
    protected DeleteTaskModal deleteTaskModal = new DeleteTaskModal();
    protected ProjectsMenu projectsMenu = new ProjectsMenu();
    protected ArchiveProjectModal archiveProjectModal = new ArchiveProjectModal();
    protected SearchResults searchResults = new SearchResults();
    protected InboxPage inboxPage = new InboxPage();
    protected ErrorModal errorModal = new ErrorModal();
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
    protected LocalDate todayDate = LocalDate.now();
    protected Random rand = new Random();

    protected static Stream<Arguments> themeColorsList() {
        return Stream.of(
                arguments("rgba(61, 61, 61, 1)", 0),
                arguments("rgba(40, 40, 40, 1)", 1),
                arguments("rgba(247, 247, 247, 1)", 2),
                arguments("rgba(255, 144, 0, 1)", 3)
        );

    }

    public void errorLoginHandle() {
        if (errorModal.errorLabel.isControlDisplayed()) {
            errorModal.okBtn.waitClickable();
            errorModal.okBtn.click();
            mainPage.loginButton.click();
            loginPage.login(email, pwd);
            loadingPage.loadingLabel.waitInvisibility();
        }
    }


}
