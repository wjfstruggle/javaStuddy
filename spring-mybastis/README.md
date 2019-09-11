### spring boot

http://localhost:8091/callback?scope=user&code=61735f98ba3cde9d9259&state=1

GET https://github.com/login/oauth/authorize

POST https://github.com/login/oauth/access_token

返回 access_token=eb59865a6dbd5d8050a381857fa2417b612f708c&scope=&token_type=bearer

https://api.github.com/user?access_token=

```json
{
  "login": "wjfstruggle",
  "id": 29621515,
  "node_id": "MDQ6VXNlcjI5NjIxNTE1",
  "avatar_url": "https://avatars3.githubusercontent.com/u/29621515?v=4",
  "gravatar_id": "",
  "url": "https://api.github.com/users/wjfstruggle",
  "html_url": "https://github.com/wjfstruggle",
  "followers_url": "https://api.github.com/users/wjfstruggle/followers",
  "following_url": "https://api.github.com/users/wjfstruggle/following{/other_user}",
  "gists_url": "https://api.github.com/users/wjfstruggle/gists{/gist_id}",
  "starred_url": "https://api.github.com/users/wjfstruggle/starred{/owner}{/repo}",
  "subscriptions_url": "https://api.github.com/users/wjfstruggle/subscriptions",
  "organizations_url": "https://api.github.com/users/wjfstruggle/orgs",
  "repos_url": "https://api.github.com/users/wjfstruggle/repos",
  "events_url": "https://api.github.com/users/wjfstruggle/events{/privacy}",
  "received_events_url": "https://api.github.com/users/wjfstruggle/received_events",
  "type": "User",
  "site_admin": false,
  "name": "wjfstruggle",
  "company": null,
  "blog": "",
  "location": null,
  "email": "2399012862@qq.com",
  "hireable": null,
  "bio": null,
  "public_repos": 31,
  "public_gists": 0,
  "followers": 5,
  "following": 2,
  "created_at": "2017-06-22T06:20:18Z",
  "updated_at": "2019-08-21T14:48:28Z",
  "private_gists": 0,
  "total_private_repos": 0,
  "owned_private_repos": 0,
  "disk_usage": 58628,
  "collaborators": 0,
  "two_factor_authentication": false,
  "plan": {
    "name": "free",
    "space": 976562499,
    "collaborators": 0,
    "private_repos": 10000
  }
}
```
```sql

```