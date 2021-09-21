import React from 'react';
import {Counter} from "./components/counter/Counter";
import {CounterButtons} from "./components/counter/CounterButtons";
import {Provider} from "react-redux";
import {store} from "./state/store";

function App() {
  return (
    <Provider store={store}>
        <Counter />
        <CounterButtons />
    </Provider>
  );
}

export default App;
