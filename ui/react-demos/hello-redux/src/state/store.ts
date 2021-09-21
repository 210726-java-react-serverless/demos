import { configureStore } from "@reduxjs/toolkit";
import counterReducer from './counterSlice';

/*
    Notes to come!
 */
export const store = configureStore({
    reducer: {
        counter: counterReducer
    }
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;