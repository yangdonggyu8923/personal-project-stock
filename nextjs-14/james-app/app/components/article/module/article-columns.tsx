import { GridColDef } from "@mui/x-data-grid";
import { ArticleColumn } from "../model/articles-column";
import { Typography } from "@mui/material";

interface CellType{
    row : ArticleColumn
}

export default function ArticleColumns(): GridColDef[] {
    return [
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'id', // 스프링 필드 이름과 같게
            headerName: 'No.',
            renderCell: ({row}:CellType) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{row.id}</Typography>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'title',
            headerName: '제목',
            renderCell: ({row}:CellType) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{row.title}</Typography>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'content',
            headerName: '내용',
            renderCell: ({row}:CellType) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{row.content}</Typography>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'writer',
            headerName: '작성자',
            renderCell: ({row}:CellType) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{row.writerId}</Typography>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'board',
            headerName: '게시판',
            renderCell: ({row}:CellType) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{row.boardId}</Typography>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'registerDate',
            headerName: '작성일자',
            renderCell: ({row}:CellType) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{row.regDate}</Typography>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'modifyDate',
            headerName: '수정일자',
            renderCell: ({row}:CellType) => <Typography textAlign="center" sx={{fontSize:"1.5rem"}}>{row.modDate}</Typography>
        }
    ]
}