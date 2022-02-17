import React from 'react'
import {Divider, List, ListItem, ListItemIcon, ListItemText, Toolbar, Typography} from '@mui/material'
import PeopleAltOutlinedIcon from '@mui/icons-material/PeopleAltOutlined'
import CommentOutlinedIcon from '@mui/icons-material/CommentOutlined'
import CategoryOutlinedIcon from '@mui/icons-material/CategoryOutlined'
import Inventory2OutlinedIcon from '@mui/icons-material/Inventory2Outlined'
import { useNavigate } from 'react-router-dom'
const Sidebar = () => {
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

    return (
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
    )
}

export default Sidebar