import React, {useState} from 'react';

import { NavbarComponent } from "./components/NavbarComponent";
import LoginComponent from "./components/LoginComponent";
import {Principal} from "./dtos/principal";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import HomeComponent from "./components/HomeComponent";

function App() {

  const [authUser, setAuthUser] = useState(undefined as Principal | undefined);

  return (
    <>

        <BrowserRouter>
            <NavbarComponent currentUser={authUser} setCurrentUser={setAuthUser}/>
            <Switch>
                <Route exact path="/" render={() => <HomeComponent currentUser={authUser} /> } />
                <Route path="/login" render={() => <LoginComponent currentUser={authUser} setCurrentUser={setAuthUser} /> } />
            </Switch>
        </BrowserRouter>

    </>
  );

}

export default App;
