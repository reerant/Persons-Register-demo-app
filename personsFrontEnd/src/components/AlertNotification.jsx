import PropTypes from "prop-types";
import AlertInfo from "./AlertInfo";

const AlertNotification = ({ alertVariant, setAlertVariant }) => {
  if (alertVariant === "success") {
    return (
      <AlertInfo
        alertVariant={alertVariant}
        setAlertVariant={setAlertVariant}
        textHeading={"The form was submitted successfully."}
        text=""
      />
    );
  } else if (alertVariant === "danger") {
    return (
      <AlertInfo
        alertVariant={alertVariant}
        setAlertVariant={setAlertVariant}
        textHeading={"Unable to submit form."}
        text="Check that all fields are filled in."
      />
    );
  } else if (alertVariant === "secondary") {
    return (
      <AlertInfo
        alertVariant={alertVariant}
        setAlertVariant={setAlertVariant}
        textHeading={"No data found with given information."}
        text=""
      />
    );
  } else {
    return null;
  }
};

AlertNotification.propTypes = {
  alertVariant: PropTypes.string.isRequired,
  setAlertVariant: PropTypes.func.isRequired,
};

export default AlertNotification;
