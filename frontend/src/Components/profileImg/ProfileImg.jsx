import React from "react";
import { Fragment } from "react";

const ProfileImg = () => {
    return(
        <Fragment>
            <img 
            style={{maxHeight:'150px'}}
            src="https://avatars.githubusercontent.com/u/31219833?v=4" 
            className=" p-0 img-thumbnail rounded-circle profile-img-border " 
            alt="GFG"
            />
        </Fragment>
    );
};

export default ProfileImg;