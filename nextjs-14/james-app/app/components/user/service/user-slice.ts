import { createSlice } from "@reduxjs/toolkit";
import { initialState } from "./user-init";
import { findAllUsers } from "./user-service";

const userThunks = [findAllUsers]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected' 
}

const handlePending = (state:any) => {}

const handleFulfilled = (state:any, {payload}:any) => {
    console.log('--conclusion--')
    state.array = payload
    console.log(state.array)
}

const handleRejected = (state:any) => {}

export const userSlice = createSlice({
    name: "users",
    initialState, // name, initialState = 속성
    reducers: {},
    extraReducers:builder =>{ // reducers, extraReducers = 기능
        const {pending, rejected} = status;

        builder.addCase(findAllUsers.fulfilled, handleFulfilled) 
    }
})

export const getAllUsers = (state:any) => {
    console.log('-- Before useSelector --')
    console.log(JSON.stringify(state.user.array))
    return state.user.array;
}

export const { } = userSlice.actions

export default userSlice.reducer; // 위는 각각의 reducers 여기선 다 합쳐져서 s가 사라진다.