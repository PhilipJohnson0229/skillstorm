import React from 'react';
import { CDBFooter, CDBFooterLink, CDBBtn, CDBIcon, CDBBox } from 'cdbreact';

export const MyFooter = () => {
  return (
    <CDBFooter className="shadow">
      <CDBBox display="flex" flex="column" className="mx-auto py-5" style={{ width: '90%' }}>
        <CDBBox display="flex" justifyContent="between" className="flex-wrap">
          <CDBBox alignSelf="center">
            <a href="/" className="d-flex align-items-center p-0 text-dark">
              <img alt="logo" src="data:image/png;base64,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" width="30px" />
              <span className="ml-3 h5 font-weight-bold">Skillstorm</span>
            </a>
            <CDBBox className="mt-5" display="flex">
              <CDBBtn flat color="dark" className="p-2">
                <CDBIcon fab icon="facebook-f" />
              </CDBBtn>
              <CDBBtn flat color="dark" className="mx-3 p-2">
                <CDBIcon fab icon="twitter" />
              </CDBBtn>
              <CDBBtn flat color="dark" className="p-2">
                <CDBIcon fab icon="instagram" />
              </CDBBtn>
            </CDBBox>
          </CDBBox>
          <CDBBox>
            <p className="h5 mb-4" style={{ fontWeight: '600' }}>
              Skillstorm
            </p>
            <CDBBox display="flex" flex="column" style={{ cursor: 'pointer' }}>
              <CDBFooterLink href="/">Resources</CDBFooterLink>
              <CDBFooterLink href="/">About Us</CDBFooterLink>
              <CDBFooterLink href="/">Contact</CDBFooterLink>
              <CDBFooterLink href="/">Blog</CDBFooterLink>
            </CDBBox>
          </CDBBox>
          <CDBBox>
            <p className="h5 mb-4" style={{ fontWeight: '600' }}>
              Products
            </p>
            <CDBBox display="flex" flex="column" style={{ cursor: 'pointer' }}>
              <CDBFooterLink href="/">Skillstorm</CDBFooterLink>
              <CDBFooterLink href="/">Loop</CDBFooterLink>
              <CDBFooterLink href="/">Contrast</CDBFooterLink>
            </CDBBox>
          </CDBBox>
          <CDBBox>
            <p className="h5 mb-4" style={{ fontWeight: '600' }}>
              Help
            </p>
            <CDBBox display="flex" flex="column" style={{ cursor: 'pointer' }}>
              <CDBFooterLink href="/">Support</CDBFooterLink>
              <CDBFooterLink href="/">Sign Up</CDBFooterLink>
              <CDBFooterLink href="/">Sign In</CDBFooterLink>
            </CDBBox>
          </CDBBox>
        </CDBBox>
        <small className="text-center mt-5">&copy; Skillstorm, 2022. All rights reserved.</small>
      </CDBBox>
    </CDBFooter>
  );
};