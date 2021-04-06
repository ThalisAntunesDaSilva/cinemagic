import React, { useState } from 'react';

import css from './PopUp.module.css';

export default function PopUp(props) {
  const { content } = props;

  const [show, setShow] = useState(true);

  const toggleShowPopUp = (event) => {
    setShow(!show);
  };

  const chooseClass = () => {
    if (show) {
      return css.modalContainer;
    }

    return css.hide;
  };

  return (
    <div className={chooseClass()} onClick={toggleShowPopUp}>
      <div className={css.modal}>{content}</div>
    </div>
  );
}
