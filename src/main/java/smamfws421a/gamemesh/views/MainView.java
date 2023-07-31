package smamfws421a.gamemesh.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route(value = "")
@PageTitle(value = "GameMesh")
@PermitAll
public class MainView extends AppLayout {

    private final H1 title = new H1("GameMesh");

    public MainView() {
        addToNavbar(title);

    }

}
