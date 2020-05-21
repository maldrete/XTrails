
export class User {
  // F I E L D S
  id: number;
  username: string;
  email: string;
  active: boolean;
  favoriteActivities: string;
  stats: string;
  role: string;
  enabled: boolean;
  password: string;
  comment: Comment[]; // need to create comment entity
  playlist: Playlist[] //
  location: Location; //

  // C O N S T R U C T O R
  constructor(
    id?: number,
    username?: string,
    email?: string,
    active?: boolean,
    favoriteActivities?: string,
    stats?: string,
    role?: string,
    enabled?: boolean,
    password?: string,
    comment?: Comment[],
    playlist?: Playlist[],
    location?: Location
  ) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.active = active;
    this.favoriteActivities = favoriteActivities;
    this.stats = stats;
    this.role = role;
    this.enabled = enabled;
    this.password = password;
    this.comment = comment;
    this.playlist = playlist;
    this.location = location;
  }

}
