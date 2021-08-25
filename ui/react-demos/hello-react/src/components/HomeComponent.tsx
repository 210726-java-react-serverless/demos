import {Principal} from "../dtos/principal";
import {Redirect} from "react-router-dom";

interface IHomeProps {
    currentUser: Principal | undefined
}

function HomeComponent(props: IHomeProps) {

    return (
        props.currentUser
        ?
        <>
            <h1>Welcome, {props.currentUser.username}!</h1>
        </>
        :
        <Redirect to="/login"/>
    )

}

export default HomeComponent;