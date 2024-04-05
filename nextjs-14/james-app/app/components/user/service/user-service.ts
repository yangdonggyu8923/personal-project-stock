import { createAsyncThunk } from "@reduxjs/toolkit";
import { fetchAllUsersAPI } from "./user-api";


export const fetchAllUsers: any = createAsyncThunk(
    'users/fetchAllUsers',
    async (page: number) => {
        console.log('fetchAllUsers page : ' + page)
        const data: any = await fetchAllUsersAPI(1);
        const { message, result }: any = data;
        console.log('----- API를 사용한 경우 ------')
        console.log('message : ' + message)
        console.log(JSON.stringify(result))
        return data
    }
)