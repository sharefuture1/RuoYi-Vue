import request from '@/utils/request'

// 查询每日任务信息列表
export function listDaily(query) {
  return request({
    url: '/wh/daily/list',
    method: 'get',
    params: query
  })
}

// 查询每日任务信息详细
export function getDaily(taskId) {
  return request({
    url: '/wh/daily/' + taskId,
    method: 'get'
  })
}

// 新增每日任务信息
export function addDaily(data) {
  return request({
    url: '/wh/daily',
    method: 'post',
    data: data
  })
}

// 修改每日任务信息
export function updateDaily(data) {
  return request({
    url: '/wh/daily',
    method: 'put',
    data: data
  })
}

// 删除每日任务信息
export function delDaily(taskId) {
  return request({
    url: '/wh/daily/' + taskId,
    method: 'delete'
  })
}
