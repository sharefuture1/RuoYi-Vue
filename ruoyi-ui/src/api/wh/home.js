import request from '@/utils/request'

// 查询home列表
export function listHome(query) {
  return request({
    url: '/wh/home/list',
    method: 'get',
    params: query
  })
}

// 查询home详细
export function getHome(taskid) {
  return request({
    url: '/wh/home/' + taskid,
    method: 'get'
  })
}

// 新增home
export function addHome(data) {
  return request({
    url: '/wh/home',
    method: 'post',
    data: data
  })
}

// 修改home
export function updateHome(data) {
  return request({
    url: '/wh/home',
    method: 'put',
    data: data
  })
}

// 删除home
export function delHome(taskid) {
  return request({
    url: '/wh/home/' + taskid,
    method: 'delete'
  })
}
