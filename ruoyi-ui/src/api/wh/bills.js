import request from '@/utils/request'

// 查询bills列表
export function listBills(query) {
  return request({
    url: '/wh/bills/list',
    method: 'get',
    params: query
  })
}

// 查询bills详细
export function getBills(date) {
  return request({
    url: '/wh/bills/' + date,
    method: 'get'
  })
}

// 新增bills
export function addBills(data) {
  return request({
    url: '/wh/bills',
    method: 'post',
    data: data
  })
}

// 修改bills
export function updateBills(data) {
  return request({
    url: '/wh/bills',
    method: 'put',
    data: data
  })
}

// 删除bills
export function delBills(date) {
  return request({
    url: '/wh/bills/' + date,
    method: 'delete'
  })
}
