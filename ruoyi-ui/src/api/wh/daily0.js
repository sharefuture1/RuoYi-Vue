import request from '@/utils/request'

// 查询每日任务信息0列表
export function listDaily0(query) {
  return request({
    url: '/wh/daily0/list',
    method: 'get',
    params: query
  })
}

// 查询每日任务信息0详细
export function getDaily0(taskId) {
  return request({
    url: '/wh/daily0/' + taskId,
    method: 'get'
  })
}

// 新增每日任务信息0
export function addDaily0(data) {
  return request({
    url: '/wh/daily0',
    method: 'post',
    data: data
  })
}

// 修改每日任务信息0
export function updateDaily0(data) {
  return request({
    url: '/wh/daily0',
    method: 'put',
    data: data
  })
}

// 删除每日任务信息0
export function delDaily0(taskId) {
  return request({
    url: '/wh/daily0/' + taskId,
    method: 'delete'
  })
}
