import { Box } from '@mui/material'
import React from 'react'

const Layout = ({children}) => {
    return (
        <Box sx={{display: 'flex'}}>

            {children}
        </Box>
    )
}

export default Layout