package smamfws421a.gamemesh.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.context.annotation.Bean;
import smamfws421a.gamemesh.components.NavbarMenu;
import smamfws421a.gamemesh.security.SecurityService;

@Route(value = "")
@PageTitle(value = "GameMesh")
@PermitAll
public class MainView extends AppLayout {

    private final SecurityService securityService;

    public MainView(SecurityService securityService) {

        this.securityService = securityService;


        H1 title = new H1("GameMesh");

        NavbarMenu menu = new NavbarMenu(securityService);

        addToNavbar(title, menu.getMenu());

    }

}
