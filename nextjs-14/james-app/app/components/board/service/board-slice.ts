import { createSlice } from "@reduxjs/toolkit";
import { countBoards, findAllBoards, findBoardById } from "./board-service";
import { initialState } from "./board-init";


const boardThunks = [findAllBoards]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}


export const boardSlice = createSlice({  
    name: "boards",
    initialState,
    reducers: {},
    extraReducers:builder =>{
        const {pending, rejected} = status;

        builder                                                 
        .addCase(findAllBoards.fulfilled, (state:any, {payload}:any)=>{state.array=payload})
        .addCase(findBoardById.fulfilled, (state:any, {payload}:any)=>{state.json=payload})
        .addCase(countBoards.fulfilled, (state:any, {payload}:any)=>{state.count=payload})
    }                                                        
})

export const getAllBoards = (state: any) => (state.board.array)
export const getOneBoard = (state: any) => (state.board.json)
export const getCountBoards = (state: any) => (state.board.count)


export const {} = boardSlice.actions

export default boardSlice.reducer;