import { createSlice } from "@reduxjs/toolkit";
import { initialState } from "./user-init";
import { countUsers, findAllUsers, findUserById, modifyUser } from "./user-service";

const userThunks = [findAllUsers]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected' 
}

// const handlePending = (state:any) => {}

// const handleFulfilled = (state:any, {payload}:any) => {
//     console.log('--conclusion--')
//     state.json = payload
//     console.log(state.json)
// }

// const handleRejected = (state:any) => {}

export const userSlice = createSlice({
    name: "users",
    initialState, // name, initialState = 속성
    reducers: {
        handlePassword: (state:any, {payload}) => {state.json.password=payload},
        handlePhone: (state:any, {payload}) => {state.json.phone=payload},
        handleJob: (state:any, {payload}) => {state.json.job=payload}
    },
    extraReducers:builder =>{ // reducers, extraReducers = 기능
        const {pending, rejected} = status;

        builder
        .addCase(findAllUsers.fulfilled,(state:any, {payload}:any)=>{state.array=payload}) 
        .addCase(findUserById.fulfilled, (state:any, {payload}:any)=>{state.json=payload})
        .addCase(countUsers.fulfilled, (state:any, {payload}:any)=>{state.count=payload})
        .addCase(modifyUser.fulfilled, (state:any, {payload}:any)=>{state.json=payload})
    }
})

export const getAllUsers = (state:any) => {
    console.log('-- Before useSelector --')
    console.log(JSON.stringify(state.user.array))
    return state.user.array;
}

export const getOneUser = (state:any) => (state.user.json)
export const getCountUsers = (state:any) => (state.user.count)

export const { handlePassword, handleJob, handlePhone} = userSlice.actions

export default userSlice.reducer; // 위는 각각의 reducers 여기선 다 합쳐져서 s가 사라진다.