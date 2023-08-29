package smamfws421a.gamemesh.views;

import com.sun.jna.platform.unix.X11;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import smamfws421a.gamemesh.components.ChessComponent;
import smamfws421a.gamemesh.components.NavbarMenu;
import smamfws421a.gamemesh.security.SecurityService;

@Route(value = "")
@PageTitle(value = "GameMesh")
@PermitAll
public class MainView extends AppLayout {

    private final SecurityService securityService;

    public MainView(SecurityService securityService) {

        this.securityService = securityService;

        //navbar
        H1 title = new H1("GameMesh");
        NavbarMenu menu = new NavbarMenu(securityService);
        addToNavbar(title, menu.getMenu());


        //chess type of bs

    }



}
