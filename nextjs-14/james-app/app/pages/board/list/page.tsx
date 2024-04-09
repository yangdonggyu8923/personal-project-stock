'use client'
import BoardColumns from "@/app/components/board/module/board-columns"
import { findAllBoards } from "@/app/components/board/service/board-service"
import { getAllBoards } from "@/app/components/board/service/board-slice"
import { Box, alpha, gridClasses, styled } from "@mui/material"
import { DataGrid } from "@mui/x-data-grid"
import { NextPage } from "next"
import { useEffect } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"


const BoardsPage: NextPage = () => {
    const dispatch = useDispatch()
    const allBoards: [] = useSelector(getAllBoards)

    if(allBoards !== undefined){
        console.log('allBoards is not undefined')

        console.log('length is ' + allBoards.length)
        for(let i=0; i<allBoards.length; i++){
            console.log(JSON.stringify(allBoards[i]))
        }
    }else{
        console.log('allBoards is undefined')
    }

    useEffect(()=>{
        dispatch(findAllBoards(1))
    },[])
    

    return (<>
    
        <Box sx={{ height: 400, width: '100%' }}>
     {allBoards && <DataGrid
        rows={allBoards}
        columns={BoardColumns()}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 5,
            },
          },
        }}
        pageSizeOptions={[5]}
        checkboxSelection
        disableRowSelectionOnClick
      />}
    </Box>
    </>)
}

export default BoardsPage