import React, {useState} from 'react';
import './App.css';

import { NavbarComponent } from "./components/NavbarComponent";
import {User} from "./models/user";

function App() {

  // const [authUser, setAuthUser] = useState(undefined as User | undefined);
  let tempUser: User = {
    id: 'kghjsad923hr982h',
    username: 'temp',
    password: 'temp',
    firstName: 'Temper',
    lastName: 'McTemperson',
    email: 'temp@revature.com'
  };

  const [authUser, setAuthUser] = useState(undefined as User | undefined);

  return (
    <NavbarComponent currentUser={authUser} setCurrentUser={setAuthUser}/>
  );

}

export default App;
