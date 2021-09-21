import {SyntheticEvent} from "react";
import {Button, Col, Row} from "react-bootstrap";
import {useDispatch} from "react-redux";
import {decrement, isLoading, isLoaded, increment, resetCount} from "../../state/counterSlice";

export const CounterButtons = () => {

    /*
        useDispatch

            Provided by Redux and allows for you to fire off actions that will trigger reducers to change
            state in some predefined way.
     */
    const dispatch = useDispatch();

    const handleIncrement = (e: SyntheticEvent) => {
        console.log('in handleIncrement, with event: ', e);
        e.preventDefault();

        dispatch(isLoading());

        setTimeout(() => {
            dispatch(increment());
            dispatch(isLoaded());
        }, 1000);
    }

    const handleDecrement = (e: SyntheticEvent) => {
        console.log('in handleDecrement, with event: ', e);
        e.preventDefault();

        dispatch(isLoading());

        setTimeout(() => {
            dispatch(decrement());
            dispatch(isLoaded());
        }, 1000);
    }

    const handleReset = (e: SyntheticEvent) => {
        console.log('in handleReset, with event: ', e);
        e.preventDefault();

        dispatch(isLoading());

        setTimeout(() => {
            dispatch(resetCount());
            dispatch(isLoaded());
        }, 1000);

    }

    return (
        <Row>
            <Col className="d-flex justify-content-center">
                <Button onClick={handleIncrement}>Add</Button>
                &nbsp;&nbsp;
                <Button onClick={handleDecrement}>Subtract</Button>
                &nbsp;&nbsp;
                <Button onClick={handleReset}>Reset</Button>
            </Col>
        </Row>
    );

}