import {Principal} from "../dtos/principal";
import {Redirect} from "react-router-dom";
import {useEffect, useState} from "react";
import {getAllUsers} from "../remote/user-service";
import {User} from "../dtos/user";
import {DataGrid} from "@material-ui/data-grid";

interface IHomeProps {
    currentUser: Principal | undefined
}

function HomeComponent(props: IHomeProps) {

    let [appUsers, setAppUsers] = useState([] as User[]);

    // The logic inside of the callback passed to useEffect will fire off on mounting and update/re-rendering

    useEffect(() => {

        if (appUsers.length === 0) {
            getAllUsers().then(users => {
                setAppUsers(users);
            })
        }

        // Any function returned from this callback is used during the unmounting of the component
        // aka: useEffect "clean up" function
        return () => {
            setAppUsers([]);
        }
    })

    const columns = [
        {
            headerName: 'First Name',
            field: 'firstName',
            width: 150
        },
        {
            headerName: 'Last Name',
            field: 'lastName',
            width: 150
        },
        {
            headerName: 'Username',
            field: 'username',
            width: 150
        },
        {
            headerName: 'Email Address',
            field: 'email',
            width: 300
        }
    ]

    return (
        props.currentUser
        ?
        <>


            <div style={{ height: 400, width: '100%' }}>
                <DataGrid
                    columns={columns}
                    rows={appUsers}
                    pagination={true}
                    pageSize={5}
                    rowsPerPageOptions={[5]}
                    checkboxSelection
                    disableSelectionOnClick
                />
            </div>

            {/*<table>*/}
            {/*    <thead>*/}
            {/*        <tr>*/}
            {/*            <th>First Name</th>*/}
            {/*            <th>Last Name</th>*/}
            {/*            <th>Username</th>*/}
            {/*            <th>Email</th>*/}
            {/*        </tr>*/}
            {/*    </thead>*/}
            {/*    <tbody>*/}
            {/*    {*/}
            {/*        appUsers.map(user => {*/}
            {/*            return (*/}
            {/*                <tr key={user.id}>*/}
            {/*                    <td>{user.username}</td>*/}
            {/*                    <td>{user.firstName}</td>*/}
            {/*                    <td>{user.lastName}</td>*/}
            {/*                    <td>{user.email}</td>*/}
            {/*                </tr>*/}
            {/*            )*/}
            {/*        })*/}
            {/*    }*/}
            {/*    </tbody>*/}
            {/*</table>*/}

        </>
        :
        <Redirect to="/login"/>
    )

}

export default HomeComponent;