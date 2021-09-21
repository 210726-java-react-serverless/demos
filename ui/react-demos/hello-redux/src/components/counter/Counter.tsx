import {Col, Container, Row} from "react-bootstrap";
import {useDispatch, useSelector} from "react-redux";
import {countState, decrement, increment, isLoaded, isLoading} from "../../state/counterSlice";
import {Loader} from './Loader';
import {SyntheticEvent} from "react";

export const Counter = () => {

    /*
        useSelector

            Gives you access to the state declared inside of the store based on the specified slice (passed as an arg)
     */
    const state: any = useSelector(countState);

    const dispatch = useDispatch();

    const up = (e: SyntheticEvent) => {
        e.preventDefault();

        dispatch(isLoading());

        setTimeout(() => {
            dispatch(increment());
            dispatch(isLoaded());
        }, 1000);
    }

    const down = (e: SyntheticEvent) => {
        e.preventDefault();

        dispatch(isLoading());

        setTimeout(() => {
            dispatch(decrement());
            dispatch(isLoaded());
        }, 1000);
    }

    return (
      <Container>
          <Row>
              <Col xs={10} md={8} lg={6} style={{height: "5rem"}} className={"border bg-dark text-light"}>
                  <Row>
                      <Col>
                          <div className="decrement" onClick={down}>&lt;</div>
                      </Col>
                      <Col>
                          <div className="count">
                              { state.isLoading ? <Loader/> : state.count }
                          </div>
                      </Col>
                      <Col>
                          <div className="increment" onClick={up}>&gt;</div>
                      </Col>
                  </Row>
              </Col>
          </Row>
      </Container>
    );

}