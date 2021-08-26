import { Alert } from '@material-ui/lab';

interface IErrorMessageProps {
    errorMessage: string;
}

function ErrorMessageComponent(props: IErrorMessageProps) {
    return (
        <Alert severity="error">{props.errorMessage}</Alert>
    )
}

export default ErrorMessageComponent;