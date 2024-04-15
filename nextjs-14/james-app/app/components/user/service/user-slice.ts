import { createSlice } from "@reduxjs/toolkit";
import { initialState } from "./user-init";
import { countUsers, deleteUserById, findAllUsers, findUserById, loginUser, modifyUser } from "./user-service";

const userThunks = [findAllUsers]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected' 
}

export const userSlice = createSlice({  // DB users테이블의 내부, 액시오스로 전달
    name: "users",
    initialState, // name, initialState = 속성
    reducers: {
        handlePassword: (state:any, {payload}) => {state.json.password=payload},
        handlePhone: (state:any, {payload}) => {state.json.phone=payload},
        handleJob: (state:any, {payload}) => {state.json.job=payload},
    },
    extraReducers:builder =>{ // reducers, extraReducers = 기능
        const {pending, rejected} = status;

        builder
        .addCase(findAllUsers.fulfilled,(state:any, {payload}:any)=>{state.array=payload}) 
        .addCase(findUserById.fulfilled, (state:any, {payload}:any)=>{state.json=payload})
        .addCase(countUsers.fulfilled, (state:any, {payload}:any)=>{state.count=payload})
        .addCase(modifyUser.fulfilled, (state:any, {payload}:any)=>{state.json=payload})
        .addCase(deleteUserById.fulfilled, (state:any, {payload}:any)=>{state.json=payload})
        .addCase(loginUser.fulfilled, (state:any, {payload}:any)=>{state.message=payload})
    }
})

export const getAllUsers = (state:any) => {
    console.log('-- Before useSelector --')
    console.log(JSON.stringify(state.user.array))
    return state.user.array;
}

export const getOneUser = (state:any) => (state.user.json)
export const getCountUsers = (state:any) => (state.user.count)
export const deleteOneUser = (state:any) => (state.user.json)

export const getLoginMessage = (state:any) => {    // DB users 테이블의 바깥
    console.log(JSON.stringify(state.user.message))
    return state.user.message
}

export const { handlePassword, handleJob, handlePhone } = userSlice.actions

export default userSlice.reducer; // 위는 각각의 reducers 여기선 다 합쳐져서 s가 사라진다.