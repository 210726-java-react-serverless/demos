import {AppBar, List, ListItem, ListItemText, Toolbar, Typography} from "@material-ui/core";
import { Link } from 'react-router-dom';
import { Principal } from "../dtos/principal";

interface INavbarProps {
    currentUser: Principal | undefined,
    setCurrentUser: (nextUser: Principal | undefined) => void
}

export function NavbarComponent(props: INavbarProps) {

    function logout() {
        props.setCurrentUser(undefined);
    }

    return (
        <>
            <AppBar color="primary" position="static">
                <Toolbar>
                    <Typography variant="h5" color="inherit">
                        <List component="nav">
                            <ListItem component="div">
                                <Typography color="inherit" variant="h5">React Demo</Typography>
                                {
                                    props.currentUser
                                        ?
                                        <>
                                            <ListItemText inset>
                                                <Typography color="inherit" variant="h6">
                                                    <Link to="/">Home</Link>
                                                </Typography>
                                            </ListItemText>
                                            <ListItemText inset>
                                                <Typography color="inherit" variant="h6" onClick={logout}>Logout</Typography>
                                            </ListItemText>
                                        </>
                                        :
                                        <>
                                            <ListItemText inset>
                                                <Typography color="inherit" variant="h6">
                                                    <Link to="/login">Login</Link>
                                                </Typography>
                                            </ListItemText>
                                            <ListItemText inset>
                                                <Typography color="inherit" variant="h6">
                                                    Register
                                                </Typography>
                                            </ListItemText>
                                        </>
                                }
                            </ListItem>
                        </List>
                    </Typography>
                </Toolbar>
            </AppBar>
        </>
    )

}