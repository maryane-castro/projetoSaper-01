import React from "react";
import { Fragment } from "react";

const Offcanvas = ({ProfileContent}) => {
    return(
        <Fragment>
            <div className="offcanvas offcanvas-start" data-bs-scroll="true" tabIndex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">
                <div className="offcanvas-header">
                    <h5 className="offcanvas-title" id="offcanvasWithBothOptionsLabel">Backdrop with scrolling</h5>
                    <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div className="offcanvas-body">
                    {ProfileContent}
                </div>
            </div>
        </Fragment>
    );
};

export default Offcanvas;