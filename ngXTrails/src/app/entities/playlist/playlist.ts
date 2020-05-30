import { User } from '../user/user';
import { Trail } from '../trail/trail';

export class Playlist {
  // F I E L D S
  id: number;
  name: string;
  description: string;
  hashtags: string;
  trails: Trail[];
  user: User;

  constructor(
    id?: number,
    name?: string,
    description?: string,
    hashtags?: string,
    trails?: Trail[],
    user?: User
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.hashtags = hashtags;
    this.trails = trails;
    this.user = user;
  }

}
