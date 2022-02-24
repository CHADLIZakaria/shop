import { AppBar, Box, Divider, List, ListItem, ListItemIcon, ListItemText, Toolbar, Typography } from '@mui/material'
import React from 'react'
import { useNavigate } from 'react-router-dom'
import PeopleAltOutlinedIcon from '@mui/icons-material/PeopleAltOutlined'
import CommentOutlinedIcon from '@mui/icons-material/CommentOutlined'
import CategoryOutlinedIcon from '@mui/icons-material/CategoryOutlined'
import Inventory2OutlinedIcon from '@mui/icons-material/Inventory2Outlined'

const Layout = ({children}) => {

    const navigate = useNavigate()
    const siderBarData = [
        {
            'title': 'Users',
            'icon': <PeopleAltOutlinedIcon />,
            'path': '/categories'
        },
        {
            'title': 'Comments',
            'icon': <CommentOutlinedIcon />,
            'path': '/categories'
        },
        {
            'title': 'Categories',
            'icon': <CategoryOutlinedIcon />,
            'path': '/categories'
        },
        {
            'title': 'Products',
            'icon': <Inventory2OutlinedIcon />,
            'path': '/categories'
        }
    ]
    const drawerWith=240

    return (
        <Box sx={{display: 'flex'}}>

            {/* Start App Bar */}
            <AppBar position='fixed' 
                sx={{
                    width: {
                        sm: `calc(100% - ${drawerWith}px)`
                    },
                    ml: {
                        sm: `${drawerWith}px`
                    }
            }}>
                <Typography>
                    This Is my app bar
                </Typography>
            </AppBar>

            {/* Start Drawer  */}
            <Box 
                component='nav'
                sx= {{
                    width: {
                        sm: `${drawerWith}px`
                    }
                }}
            >   
                <div>
                    <Toolbar>
                        <Typography>
                            Shop
                        </Typography>
                    </Toolbar>
                    <Divider />
                    <List>
                        {siderBarData.map((siderBarLink, index) => (
                            <ListItem button key={index} onClick={() => navigate(siderBarLink.path)}>
                                <ListItemIcon>
                                    {siderBarLink.icon}
                                </ListItemIcon>
                                <ListItemText primary={siderBarLink.title} />
                            </ListItem>
                        ))}
                    </List>
                </div>
            </Box>
            
            {children}
        </Box>
    )
}

export default Layout